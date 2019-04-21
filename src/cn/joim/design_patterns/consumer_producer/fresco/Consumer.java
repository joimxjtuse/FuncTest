package cn.joim.design_patterns.consumer_producer.fresco;

/**
 * Created by Joim-PC on 2016/6/12.
 */
public interface Consumer {

    public void onNewResult();

    public void onFailure();

    public void onProgressUpdate();
}
