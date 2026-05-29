package domain;

public class Publisher {
    private String publisherCode;
    private String publisherName;
    private String address;
    private String phone;

    public Publisher() {}

    public Publisher(String publisherCode, String publisherName,
                     String address, String phone) {
        this.publisherCode = publisherCode;
        this.publisherName = publisherName;
        this.address       = address;
        this.phone         = phone;
    }

    public String getPublisherCode()          { return publisherCode; }
    public void   setPublisherCode(String v)  { this.publisherCode = v; }
    public String getPublisherName()          { return publisherName; }
    public void   setPublisherName(String v)  { this.publisherName = v; }
    public String getAddress()                { return address; }
    public void   setAddress(String v)        { this.address = v; }
    public String getPhone()                  { return phone; }
    public void   setPhone(String v)          { this.phone = v; }

    @Override
    public String toString() {
        return String.format("[%-12s] %-22s %-40s %s",
                publisherCode, publisherName, address, phone);
    }
}