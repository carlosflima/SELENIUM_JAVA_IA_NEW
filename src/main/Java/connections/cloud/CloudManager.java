package connections.cloud;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.regions.Region;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class CloudManager {

    // --- AWS S3 Implementation ---
    public static S3Client getS3Client() {
        return S3Client.builder()
                .region(Region.US_EAST_1) // Centralizado via variável global
                .build();
    }

    // --- Azure Blob Implementation ---
    public static BlobServiceClient getAzureClient() {
        String connectionString = System.getProperty("azure.connection.string");
        return new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .build();
    }
}