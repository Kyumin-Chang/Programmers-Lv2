import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OpenChatRoomTest {
    @DisplayName("오픈 채팅방 테스트")
    @Test
    void mainTest() {
        OpenChatRoom openChatRoom = new OpenChatRoom();
        String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};
        String[] answer = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        String[] result = openChatRoom.solution(records);
        System.out.println(Arrays.toString(result));
        assertThat(result).isEqualTo(answer);
    }
}
