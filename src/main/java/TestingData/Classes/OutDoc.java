package TestingData.Classes;

import java.util.ArrayList;
import java.util.List;

public class OutDoc {
    private DeliveryType deliveryType;
    private String deliveryDetails;
    private String type;
    private String from;
    private List<String> inputDocList = new ArrayList<String>();
    private String name;
    private List<Org> orgs = new ArrayList<Org>();
    private List<String> whoSignsList = new ArrayList<String>();
    private List<String> performerList = new ArrayList<String>();
    private String additionalInfo;
    private List<String> attachmentsPathsList = new ArrayList<String>();

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getInputDocList() {
        return inputDocList;
    }

    public void addIncomingDoc(String inputDoc) {
        this.inputDocList.add(inputDoc);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Org> getOrgs() {
        return orgs;
    }

    public void addOrg(Org org) {
        this.orgs.add(org);
    }

    public List<String> getWhoSignsList() {
        return whoSignsList;
    }

    public void addWhoSigns(String whoSigns) {
        this.whoSignsList.add(whoSigns);
    }

    public List<String> getPerformerList() {
        return performerList;
    }

    public void addPerformer(String performer) {
        this.performerList.add(performer);
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<String> getAttachmentsPathsList() {
        return attachmentsPathsList;
    }

    public void setAttachmentsPathsList(List<String> attachmentsPathsList) {
        this.attachmentsPathsList = attachmentsPathsList;
    }
}
