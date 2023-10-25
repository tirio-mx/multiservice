package mx.tirio.app.multiservice.dispatcher.infraestructure;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceDTO;
import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceTypeDTO;
import mx.tirio.app.multiservice.dispatcher.domain.output.ServiceStorePort;
import mx.tirio.app.multiservice.dispatcher.infraestructure.model.ServiceEntity;
import mx.tirio.app.multiservice.dispatcher.infraestructure.model.ServiceTypeEntity;

/**
 * JPA Adapter used to access ServiceRepository.
 * 
 * @author Gerardo Corsan
 */
@Component
public class ServiceAdapter implements ServiceStorePort {

	/**
	 * Attribute serviceRepository.
	 */
	@Autowired
	private ServiceRepository serviceRepository;

	/**
	 * Used to convert service type entity into DTO.
	 * 
	 * @param entity service type entity
	 * @return service type DTO
	 */
	private ServiceTypeDTO serviceTypeEntityToDto(final ServiceTypeEntity entity) {
		ServiceTypeDTO serviceType = new ServiceTypeDTO();
		BeanUtils.copyProperties(entity, serviceType);

		return serviceType;
	}

	/**
	 * Used to convert service entity into DTO.
	 * 
	 * @param entity service entity
	 * @return service DTO
	 */
	private ServiceDTO serviceEntityToDto(final ServiceEntity entity) {
		ServiceTypeDTO serviceType = serviceTypeEntityToDto(entity.getServiceType());
		ServiceDTO service = ServiceDTO.builder().build();
		BeanUtils.copyProperties(entity, service);
		service.setServiceType(serviceType);

		return service;
	}

	public static List<String> obtenerNombresArchivosJSON(String rutaDirectorio) throws IOException {
		List<String> archivosJSON = new ArrayList<>();

		Path directorio = Paths.get(rutaDirectorio);

		Files.walkFileTree(directorio, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (file.toString().toLowerCase().endsWith(".json")) {
					String fileName = file.getFileName().toString();
					int lastIndex = fileName.lastIndexOf(".");
					String shortFileName = fileName.substring(0, lastIndex);
					archivosJSON.add(shortFileName);
				}
				return FileVisitResult.CONTINUE;
			}
		});

		return archivosJSON;
	}

	/**
	 * Retrieve a list of services.
	 * 
	 * @return the list of services.
	 */
	public List<ServiceDTO> getServiceList() {
//        List<ServiceDTO> services = StreamSupport.stream(serviceRepository.findAll().spliterator(), false)
//                .map(entity -> {
//                    ServiceDTO service = serviceEntityToDto(entity);
//                    return service;
//                }).collect(Collectors.toList());
//
		List<ServiceDTO> services = new LinkedList<>();
		String rutaDirectorio = "./data/responses";
		Path directorio = Paths.get(rutaDirectorio);

		try {
			Files.walkFileTree(directorio, new SimpleFileVisitor<Path>() {
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if (file.toString().toLowerCase().endsWith(".json")) {
						String fileName = file.getFileName().toString();
						int lastIndex = fileName.lastIndexOf(".");
						String shortFileName = fileName.substring(0, lastIndex);
						BasicFileAttributes atributos = Files.readAttributes(file, BasicFileAttributes.class);
						Date fechaCreacion = new Date(atributos.creationTime().toMillis());

						ServiceDTO dto = ServiceDTO.builder()
								.creationDate(fechaCreacion)
								.descripcion(shortFileName)
								.build();
						dto.setStatus(null);
						services.add(dto);
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		return services;
	}

}
