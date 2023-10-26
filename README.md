#MultiService App
Multiservice

* To start the aplication, execute:
```
./start.sh
```

* For uploading new service responses, run the command:
```
curl -X POST -F "file=@./notificacion.json" http://localhost:8050/multiservice/admin/upload
```

* For removing a service responses, run the command:
```
curl -X POST -H "Content-Type: application/json" -d '{"serviceId": "notificacion", "key": "L@m4n6a"}' http://localhost:8050/multiservice/admin/remove
```
