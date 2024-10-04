class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int m = Integer.parseInt(pos.split(":")[0]);
        int s = Integer.parseInt(pos.split(":")[1]);

        int startM = Integer.parseInt(op_start.split(":")[0]);
        int startS = Integer.parseInt(op_start.split(":")[1]);
        int endM = Integer.parseInt(op_end.split(":")[0]);
        int endS = Integer.parseInt(op_end.split(":")[1]);

        if (60 * m + s >= 60 * startM + startS && 60 * m + s <= 60 * endM + endS) {
            m = endM;
            s = endS;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                s -= 10;
                if (m == 0 && s < 0) {
                    m = 0;
                    s = 0;
                }
                if (s < 0) {
                    m -= 1;
                    s += 60;
                }
                if (60 * m + s >= 60 * startM + startS && 60 * m + s <= 60 * endM + endS) {
                    m = endM;
                    s = endS;
                }
                continue;
            }

            if (command.equals("next")) {
                s += 10;
                if (s >= 60) {
                    m += 1;
                    s -= 60;
                }
                if (m >= Integer.parseInt(video_len.split(":")[0]) && s >= Integer.parseInt(video_len.split(":")[1]) ) {
                    m = Integer.parseInt(video_len.split(":")[0]);
                    s = Integer.parseInt(video_len.split(":")[1]);
                }
                if (60 * m + s >= 60 * startM + startS && 60 * m + s <= 60 * endM + endS) {
                    m = endM;
                    s = endS;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (m < 10 && s < 10) {
            return sb.append(0).append(m).append(":").append(0).append(s).toString();
        } else if (s < 10) {
            return sb.append(m).append(":").append(0).append(s).toString();
        } else if (m < 10) {
            return sb.append(0).append(m).append(":").append(s).toString();
        }

        return sb.append(m).append(":").append(s).toString();
    }
}