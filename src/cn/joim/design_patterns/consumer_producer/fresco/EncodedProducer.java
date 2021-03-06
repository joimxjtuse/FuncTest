package cn.joim.design_patterns.consumer_producer.fresco;

/**
 * Created by Joim-PC on 2016/6/12.
 */
public class EncodedProducer  implements Producer{

    private Producer mProducer;

    @Override
    public void produceResult(Consumer consumer) {
        if(hasResult()){
            consumer.onNewResult();
        }else if(shouldContinueLoad()){
            mProducer.produceResult(new EncodeConsumer(consumer));
        }else{
            consumer.onFailure();
        }
    }

    /**
     *
     *
     * */
    public boolean hasResult(){
        return false;
    }

    /**
     * 是否需要其他人生产.
     * */
    public boolean shouldContinueLoad(){
        return false;
    }

    private class EncodeConsumer implements Consumer{

        Consumer consumer;
        EncodeConsumer(Consumer consumer){
            this.consumer = consumer;

        }
        @Override
        public void onNewResult() {
            consumer.onNewResult();
            // do bitmap thing.
        }

        @Override
        public void onFailure() {

        }

        @Override
        public void onProgressUpdate() {

        }
    }
}
