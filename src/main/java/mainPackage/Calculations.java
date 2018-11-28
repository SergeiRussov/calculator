package mainPackage;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "mainPackage.Calculations")
public class Calculations implements Serializable {

    @XmlElement
    private double x, y, answer;
    @XmlElement
    private int oct, dec;
    @XmlElement
    private long bin;
    @XmlElement
    private String hex;

    public Calculations() {

    }

    public Calculations (double x) {
        this.x = x;
    }

    public Calculations (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public long getBin() {
        return bin;
    }

    public void setBin(long bin) {
        this.bin = bin;
    }

    public int getOct() {
        return oct;
    }

    public void setOct(int oct) {
        this.oct = oct;
    }

    public int getDec() {
        return dec;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

}
