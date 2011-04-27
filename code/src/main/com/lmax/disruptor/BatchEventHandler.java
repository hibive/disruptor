package com.lmax.disruptor;

/**
 * Callback interface to be implemented for processing events has the are published from the {@link RingBuffer}
 *
 * @param <T> Entry implementation storing the data for sharing during exchange or parallel coordination of an event.
 */
public interface BatchEventHandler<T extends Entry>
{
    /**
     * Called when a publisher has committed an {@link Entry} to the {@link RingBuffer}
     *
     * @param entry committed to the {@link RingBuffer}
     * @throws Exception if the BatchEventHandler would like the exception handled further up the chain.
     */
    void onEvent(T entry) throws Exception;

    /**
     * Called after each batch of items has been have been processed before the next waitFor call on a {@link ThresholdBarrier}
     *
     * @throws Exception if the BatchEventHandler would like the exception handled further up the chain.
     */
    void onEndOfBatch() throws Exception;

    /**
     * Called when process of events is complete for clean up.
     */
    void onCompletion();
}
