package foodchain.party;

import foodchain.channels.Channel;
import foodchain.channels.util.Request;
import foodchain.transactions.Transaction;

public interface ChannelObserver {
    void attach(Channel channel);

    void detach(Channel channel);

    void update(Request request);

    void update(Transaction transaction);
}
