# Licitations 💰

## Project summary

  In licitation program distributed system is projected. Program works in system with connected computers. Application supports central server, servers and clients.\ 
  Central server tracks prices of items. Periodically, central server sends prices of interest to subscribed users. This message contains item name, current price and licitation time.\
  Every item is associated to one server.\
  Users can subscribe to server sending username and password. After subscriptions, users periodically get information about avaliable items. Users can place bids for selected item with new price. Also, users can publish new item to licitation, providing item name, description, starting price and licitation time.\
  Every user starts with some amount od money(different for every user). He will gain money when he sell an item and lose money when he buys one. User can bid for more money than he have curently on account, but the transaction will not go trough if he doesn't have enough money at the end of licitation.\
 When licitation ends system chek if purchasing is possible, if the highest bidder doesn't have enough money, system waits for some time and checks again. If the highest bidder still doesn't have enough money second highest bidder is offered a chance to buy this item. If the second highest bidder declines offer item is placed back for licitation with same startting parameters. Each action is accompanied by an appropriate message.

## Programming language and libraries

Project is implemented in Scala. 
Java.net and Java RMI libraries will be used to support distributed concepts.

## Authors 

- Dubravka Kutlesic, @dkutlesic , dubravka@gmail.com 
- Ognjen Milinkovic, @ognjenivuk , ognjen7amg@gmail.com


