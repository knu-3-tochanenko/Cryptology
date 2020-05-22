import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String toEncrypt = "Lla";
        String key = "123456780ABCDEF0";

        XTEA tea = new XTEA(key.getBytes());

        byte[] original = toEncrypt.getBytes();

        System.out.println("To encrypt: " + toEncrypt);
        byte[] crypt = tea.encrypt(original);

        System.out.println(new String(Base64.getEncoder().encode(crypt)));

        byte[] result = tea.decrypt(crypt);
        System.out.println("Decrypted : " + new String(result));
    }
}
