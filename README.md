Food Chain: Eduard Nurmukhametov a Khomutov Mikhail

Funkcní požadavky:

F1: src/main/java/foodchain/party
F2: (foodchain/party package) Processor sets parameters also all parties when the do their transaction(For example addSellTransaction(ProductChannel)) they change state of product
F3: (foodchain/transactions package) Transaction has previous transaction and also has hashes made with previous transaction(what also has it's own hash)
F4: Food Chain report, in any part of code you can sk to show it and it will do it
F5: (foodchain/channels package)ProductChannel, MoneyChannel what are extending abstract class Channel
F6: (foodchain/party package)When someone(Seller) does Sell transaction(ProductChannel) we are checking Uuid of product with Uuid of previous products
F7: Nevim, nerozumim asi
F8: When someone does transaction in transaction the state of product changes:
F9: (channels/util package package) Requests, method addRequest(ProductChannel) makes it possible
F10: (foodchain package) Reporter: addPartiesReport - showPartiesReport, addFoodChainReport - showFoodChainReport, addSecurityReport - showSecurityReport, addTransactionReport - showTransactionReport

Nefunkční požadavky:
ení požadována autentizace ani autorizace
●	Není požadována autentizace ani autorizace
●	Aplikace nemá GUI. Aplikace komunikuje s uživatelem pomocí výpisů do souboru
●	V systému neexistuje centrální autorita, přes kterou by se prováděly transakce. Aplikaci běží v jednom threadu, kdy se postupně aplikují všechny transakce provedené jednotlivými parties v rámci aktuálního kroku diskrétní simulace.
●	Myslim ze všechno je dobře ukryté
●	Namísto PKI infrastruktury, public a private klíčů, šifrování/dešifrování pracujeme s Uuid. Každy product ma svoje Immutable Uuid(foodchain/Products package, Object Product)
●	Reporty jsou generovány do textového souboru
●	Program běží v Mainu package builder



Design patterns:
    
    Singleton: Reporter
    
    Builder: package builder: FoodChainBuilder

    Iterator: package transactions: TransactionIterator

    State: package products: ProductState

    Observer: package channels: PartyObservable, package party: ChannelObserver

    Factory Method: package praty/farmer ProductFactory

    Strategy: package products: ParametersStrategy
    

Discretni krok 0:      

    Customer makes request for product(2kg of "BEEF") addressed to Seller

    Seller answers and does not find product in his products -> he makes request adressed to Storage

    Storage answers and does not find product -> it makes request addressed to Processor

    Processor answers and does not find product -> he makes request addressed to Farmer

    Farmer answers and creates a product and asks distributor to deliver it to Processor

    Distributor delivers product to Processor

    Processor sets Parameters strategy and asks distributor to deliver product to Storage

    Distributor delivers product to Storage

    Storage asks distributor to deliver product to Seller

    Distributor delivers product to Seller


    Here important moment: we are doing the same product with same Uuid, in all - copy

    it saves inside of other seller, let's call him Albert(Seller)


    Seller asks distributor to deliver product to Customer

    Distributor delivers product to Customer

Discretni krok 1:

    Customer makes again request for product(2kg of "BEEF") addressed to Seller

    Albert(Seller) answers and when he makes Sell Transaction, double-spending error appears

