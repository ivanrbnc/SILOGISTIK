# Individual Assignment APAP

## Brief Description
This project is all about warehouses and delivery where you can assign items into warehouses and send them to someone who ordered them. This project use Indonesian and English language. Few words that you'll meet are Gudang (Warehouse), Barang (Item), Permintaan (Request), and Pengiriman (Delivery). The rest of the words are free for you to translate them.

## Upcoming Updates
* Simplify each controller by move some codes into services
* Make Restock feature more efficient by minimizing DTO request.
* Create delivery feature that decrement stock in warehouses

## How to run
1. Run your Docker Dekstop
	
	![preview_docker](https://cdn.discordapp.com/attachments/935244474349678633/1163126328648810496/image.png?ex=653e70ce&is=652bfbce&hm=585fe8d5ec3d67a917651dea2a9d89b410f9fa7e645156959859aa471c0d9f83&)
2. Create database named "silogistik" in Dbeaver. You can change the database name in 
	```
	...\silogistik2106701892\src\main\resouces\application.properties
	```
	and change the value of `spring.datasource.url` into `jdbc:postgresql://localhost:15001/<database name>`

	![right_click_on_database](https://cdn.discordapp.com/attachments/935244474349678633/1163114203977097296/image.png?ex=653e6583&is=652bf083&hm=dda080833e0493501f9075c21cbf2f9c4599e1397a7688abe0f873386b4b8686&)
	
	![name_it_silogistik](https://cdn.discordapp.com/attachments/935244474349678633/1163114295899463791/image.png?ex=653e6599&is=652bf099&hm=610efd999e66476b2515bc4b4e887823331596ae408222c1552737fa0fdf5094&)

3. Run this command to activate your database
	
	```java 
	docker-compose up	
	```

4. If you want to change username and password for the db, search for 
	```
	...\silogistik2106701892\src\main\resouces\application.properties
	```
	You'll notice there is two attribute, `spring.datasource.username` and `spring.datasource.password`. 
	
	- To customize this, run `docker ps` in the same cmd terminal as when you run your docker. 
	- Copy the container ID
	- Run `docker exec -it <container ID> psql -U postgres`
	- Run `CREATE USER <database username> with PASSWORD "<database password>";`
	- Lastly, run `ALTER USER <database username> WITH SUPERUSER;`
	- To check if it's created, you may exit the terminal. Run it again and run `docker exec -it <container ID> psql -h localhost -d <database source url, for this project, its name is silogistik> -U <database username>`

5. Run the `Silogistik2106701892Application.java` on file location 
	
	```
	...\silogistik2106701892\src\main\java\apap\ti\silogistik2106701892
	```

## Authors

* **Ivan Rabbani Cezeliano** - *2106701892* - *C* 