package jp.buyee.glover;

import com.amazonaws.services.kinesis.connectors.KinesisConnectorConfiguration;
import com.amazonaws.services.kinesis.connectors.impl.AllPassFilter;
import com.amazonaws.services.kinesis.connectors.impl.BasicMemoryBuffer;
import com.amazonaws.services.kinesis.connectors.impl.JsonToByteArrayTransformer;
import com.amazonaws.services.kinesis.connectors.interfaces.*;
import com.amazonaws.services.kinesis.connectors.s3.S3Emitter;

/**
 * Created by nico on 2015/11/01.
 */
public class S3Pipeline implements IKinesisConnectorPipeline<GloverAccesslogModel, byte[]> {

    @Override
    public IEmitter<byte[]> getEmitter(KinesisConnectorConfiguration configuration) {
        return new S3Emitter(configuration);
    }

    @Override
    public IBuffer<GloverAccesslogModel> getBuffer(KinesisConnectorConfiguration configuration) {
        return new BasicMemoryBuffer<GloverAccesslogModel>(configuration);
    }

    @Override
    public ITransformer<GloverAccesslogModel, byte[]> getTransformer(KinesisConnectorConfiguration configuration) {
        return new JsonToByteArrayTransformer<GloverAccesslogModel>(GloverAccesslogModel.class);
    }

    @Override
    public IFilter<GloverAccesslogModel> getFilter(KinesisConnectorConfiguration configuration) {
        return new AllPassFilter<GloverAccesslogModel>();
    }
}
