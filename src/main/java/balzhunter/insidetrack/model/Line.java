package balzhunter.insidetrack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Line {
    @Id
    private String id;
    private Number invoiceNumber;
    private String invoiceDate;
    private String distributorName;
    private String distributorAddress;
    private String customerName;
    private String customerAddress;
    private String manufacturerName;
    private String manufacturerAddress;
    private Number productCode;
    private String productDescription;
    private String unitOfMeasure;
    private Number quantity;
    private Number weight;
    private Number unitPrice;
    private Number totalPrice;
}
