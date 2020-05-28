public class Shop {
	private String shopName;
	private String locality;
	private String slot;
	private String id;
	
	public Shop(String id,String shopName, String locality, String slot) {
		super();
		this.shopName = shopName;
		this.locality = locality;
		this.slot = slot;
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", locality=" + locality + ", slot=" + slot + ", id=" + id + "]";
	}
	
	
}
