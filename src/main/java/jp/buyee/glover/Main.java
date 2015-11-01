package jp.buyee.glover;

import com.amazonaws.services.kinesis.connectors.KinesisConnectorRecordProcessorFactory;

/**
 * Created by nico on 2015/11/01.
 */
public class Main extends KinesisConnectorExecutor<GloverAccesslogModel, byte[]> {
    private static final String CONFIG_FILE = "S3Sample.properties";

    /**
     * Creates a new S3Executor.
     *
     * @param configFile
     *        The name of the configuration file to look for on the classpath
     */
    public Main(String configFile) {
        super(configFile);
    }

    @Override
    public KinesisConnectorRecordProcessorFactory<GloverAccesslogModel, byte[]>
    getKinesisConnectorRecordProcessorFactory() {
        return new KinesisConnectorRecordProcessorFactory<GloverAccesslogModel, byte[]>(new S3Pipeline(), this.config);
    }

    /**
     * Main method to run the S3Executor.
     *
     * @param args
     */
    public static void main(String[] args) {
        KinesisConnectorExecutor<GloverAccesslogModel, byte[]> s3Executor = new Main(CONFIG_FILE);
        s3Executor.run();
    }
}
