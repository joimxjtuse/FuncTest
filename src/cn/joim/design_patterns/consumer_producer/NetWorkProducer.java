package cn.joim.design_patterns.consumer_producer;

/**
 * Created by Joim-PC on 2016/6/12.
 */
public class NetWorkProducer implements Producer {

    @Override
    public void produceResult(Consumer consumer) {
        if(hasResult()){
            consumer.onNewResult();
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
}
