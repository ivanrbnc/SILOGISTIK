# Individual Assignment APAP

## Brief Description
This project is a simple project about warehouses and delivery where you can assign items into warehouses and send them to someone who ordered them. This project use Indonesian and English language. Few words that you'll meet are Gudang (Warehouse), Barang (Item), Permintaan (Request), and Pengiriman (Delivery). The rest of the words are free for you to translate them.

## Upcoming Updates
* Simplify each controller by move some codes into services
* Make Restock feature more efficient by minimizing DTO request.
* Create delivery feature that decrement stock in warehouses

## How to run
1. Run your Docker Dekstop
	
	![preview_docker](https://cdn.discordapp.com/attachments/935244474349678633/1163126328648810496/image.png?ex=653e70ce&is=652bfbce&hm=585fe8d5ec3d67a917651dea2a9d89b410f9fa7e645156959859aa471c0d9f83&)

2. Run this command to activate your docker into the database
	
	```java 
	docker-compose up	
	```

3. Create database named "silogistik" in Dbeaver. 

	![right_click_on_database](https://cdn.discordapp.com/attachments/935244474349678633/1163114203977097296/image.png?ex=653e6583&is=652bf083&hm=dda080833e0493501f9075c21cbf2f9c4599e1397a7688abe0f873386b4b8686&)
	
	![name_it_silogistik](https://cdn.discordapp.com/attachments/935244474349678633/1163114295899463791/image.png?ex=653e6599&is=652bf099&hm=610efd999e66476b2515bc4b4e887823331596ae408222c1552737fa0fdf5094&)

4. Run the `Silogistik2106701892Application.java` on file location 
	
	```
	...\silogistik2106701892\src\main\java\apap\ti\silogistik2106701892
	```

5. If you want to customize database name, database username, database password, or even the port, change it through here.
	```
	...\silogistik2106701892\src\main\resouces\application.properties
	```

	If you are already satisfied, create new connection through DBeaver.

	![new_connection](https://cdn.discordapp.com/attachments/935244474349678633/1164184410443231302/image.png?ex=65424a38&is=652fd538&hm=6bb8b45ff1be2d52b7f586007da903245bb72a826986e74d080cc3b13b8918f6&)

	![customize_database](https://cdn.discordapp.com/attachments/935244474349678633/1164186304418938930/image.png?ex=65424bfc&is=652fd6fc&hm=2f8e9b6006db96ff9becb7578ba1b7e138db7ac1ef2de8f0097f31083131fec1&)
	

## Authors

* **Ivan Rabbani Cezeliano** - *2106701892* - *C* 