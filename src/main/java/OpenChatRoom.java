import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OpenChatRoom {
    /*
    40분 소요
    ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
    ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
     */
    public String[] solution(String[] record) {
        Map<String, String> id_Name = new HashMap<>(); //id , name
        List<String> id_access = new ArrayList<>(); // id, enter
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] msg = record[i].split(" ");
            if (Objects.equals(msg[0], "Enter")) {
                id_Name.put(msg[1], msg[2]);
                id_access.add(msg[1] + " " + msg[0]);
            }
            if (Objects.equals(msg[0], "Leave")) {
                id_access.add(msg[1] + " " + msg[0]);
            }
            if (Objects.equals(msg[0], "Change")) {
                id_Name.put(msg[1], msg[2]);
            }
        }

        for (int i = 0; i < id_access.size(); i++) {
            String[] id_msg = id_access.get(i).split(" ");
            if (Objects.equals(id_msg[1], "Enter")) {
                answerList.add(enterMessage(id_Name.get(id_msg[0])));
            }
            if (Objects.equals(id_msg[1], "Leave")) {
                answerList.add(leaveMessage(id_Name.get(id_msg[0])));
            }
        }
        return answerList.toArray(new String[0]);
    }

    public String enterMessage(String name) {
        return name + "님이 들어왔습니다.";
    }

    public String leaveMessage(String name) {
        return name + "님이 나갔습니다.";
    }
}
