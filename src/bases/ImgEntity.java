package bases;

/**
 * Created by Big_Boss on 2017/7/18.
 */
public class ImgEntity {
    private int serialNumber;
    private String path;

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImgEntity imgEntity = (ImgEntity) o;

        if (serialNumber != imgEntity.serialNumber) return false;
        if (path != null ? !path.equals(imgEntity.path) : imgEntity.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serialNumber;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }
}
