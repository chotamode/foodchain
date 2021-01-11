Design patterns:
    Singleton: Reporter
    
    Builder: package builder: FoodChainBuilder

    Iterator: TransactionIterator

    State: ProductState

    Observer: PartyObservable, ChannelObserver

    Factory Method: ProductFactory

    Strategy: ParametersStrategy
    

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

