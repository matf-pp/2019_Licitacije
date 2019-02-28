# Licitations 💰

## Project summary

In licitation program distributed system is projected. Program works in system with connected computers. Application supports central server, servers and clients.Central server tracks prizes of items. Periodically, central server sends prizes of interest to subscribed users. This message contains item name, current prize and licitation time. Every item is associated to one server. Periodically, servers send messages to central server with current items information. Users can subscribe to server sending username and password. After subscriptions, users periodically get information about avaliable items. Users can make purchase for selected item with new prize. When central server receives purchasing request, connects associated server. Also, users can publish new item to licitation, providing item name, description, starting prize and licitation time. When central server receives message about new item, picks server for it. Every user has money account. Money amount can be changed. Transaction canceling is possible, but with time constraints. Sending licitation prize higher than account amount is possible. System waits for some time and check if purchasing is possible. If purchasing is still unable, transaction is cancelled. When transaction is successed or cancelled, user gets message info. 

## Programming language and libraries

Project is impleented in C++.

## Authors 

- Dubravka Kutlesic, @dkutlesic , dubravka@gmail.com 
- Ognjen Milinkovic, @ognjenivuk , ognjen7amg@gmail.com


