package foodchain.party;

import foodchain.channels.Channel;
import foodchain.channels.util.RP;
import foodchain.channels.util.Request;

import java.util.List;

public interface ChannelObserver {
    void update(RP request);
    void attach(Channel channel);
    void detach(Channel channel);
}
