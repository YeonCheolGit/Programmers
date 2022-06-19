import java.util.*;

// soulution()에 입력된 파라미터들이 snake_case이므로 이를 따릅니다.
class take_report_result {
    public int[] solution(String[] id_list, String[] report, int k) {        
        Map<String, HashSet<String>> reported_reporters = initialize_reported_reporters(report);
        reported_reporters = add_reporter(report, reported_reporters);
        
        Map<String, Integer> send_email_counts = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            send_email_counts.put(id_list[i], i);
        }
        
        return calculate_send_email_count(id_list, reported_reporters, k, send_email_counts);
    }
    
    public Map<String, HashSet<String>> initialize_reported_reporters(String[] report) {
        Map<String, HashSet<String>> reported_reporters = new HashMap<>();
        
        for (String r : report) {
            String reported = r.split(" ")[1];
            reported_reporters.put(reported, new HashSet<>());            
        }
        
        return reported_reporters;
    }
    
    public Map<String, HashSet<String>> add_reporter(String[] report, Map<String, HashSet<String>> reported_reporters) {
        for (String r : report) {
            String reporter = r.split(" ")[0];
            String reported = r.split(" ")[1];
            reported_reporters.get(reported).add(reporter);
        }
        
        return reported_reporters;
    }
    
    public int[] calculate_send_email_count(String[] id_list, Map<String, HashSet<String>> reported_reporters,
                                           int k, Map<String, Integer> send_email_counts) {
        int[] answer = new int[id_list.length];
        
        for (int i=0; i<id_list.length; i++) {
            if (Util.is_present(reported_reporters.get(id_list[i]))) {
                HashSet<String> reporters = reported_reporters.get(id_list[i]);
                if (Util.is_available_send_email(reporters.size(), k)) {
                    for (String reporter_name : reporters) {
                        answer[send_email_counts.get(reporter_name)]++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    static class Util {
        public static boolean is_present(HashSet<String> set) {
            return set != null;
        }
        
        public static boolean is_available_send_email(int reporters_size, int k) {
            return reporters_size >= k;
        }
    }
}


