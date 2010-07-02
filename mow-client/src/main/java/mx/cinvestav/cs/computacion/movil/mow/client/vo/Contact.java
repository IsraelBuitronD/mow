package mx.cinvestav.cs.computacion.movil.mow.client.vo;

/**
 * @author Israel Buitron
 */
public class Contact {
    private String nickname;
    private String macAddr;
    private String ipv4Addr;

    public Contact() {
    }

    public Contact(String nickname,
		   String macAddr,
		   String ipv4Addr) {
	this.nickname = nickname;
	this.macAddr = macAddr;
	this.ipv4Addr = ipv4Addr;
    }

    public String getNickname() {
	return this.nickname;
    }

    public void setNickname(String n) {
	this.nickname = n;
    }

    public String getMacAddr() {
	return this.macAddr;
    }

    public void setMacAddr(String m) {
	this.macAddr = m;
    }

    public String getIpv4Addr() {
	return this.ipv4Addr;
    }

    public void setIpv4Addr(String i) {
	this.ipv4Addr = i;
    }

}
