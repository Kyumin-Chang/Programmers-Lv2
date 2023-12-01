import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {
    @DisplayName("전화번호 목록 테스트")
    @Test
    void mainTest() {
        PhoneBook phoneBook = new PhoneBook();
        String[] phone = {"119", "97674223", "1195524421"};
        Boolean result = phoneBook.solution(phone);
        System.out.println(result);
        assertThat(result).isEqualTo(false);
    }
}
