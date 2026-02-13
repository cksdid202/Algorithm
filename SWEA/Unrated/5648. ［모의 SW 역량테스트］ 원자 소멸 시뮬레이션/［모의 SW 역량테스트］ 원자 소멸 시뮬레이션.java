import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static class Atom {
        int x, y, dir, energy;

        public Atom(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }

    // 좌표 2배 확장 (-1000~1000 -> -2000~2000 -> 0~4000)
    static int[][] map = new int[4001][4001];
    static ArrayList<Atom> atoms;
    static int totalEnergy;

    // 상(0), 하(1), 좌(2), 우(3)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            atoms = new ArrayList<>();
            totalEnergy = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                // [핵심 1] 0.5초 충돌 처리를 위해 좌표계 2배 확대 및 음수 제거
                x = (x * 2) + 2000;
                y = (y * 2) + 2000;

                atoms.add(new Atom(x, y, dir, k));
            }

            simulate();

            sb.append("#").append(t).append(" ").append(totalEnergy).append("\n");
        }
        System.out.print(sb);
    }

    private static void simulate() {
        while (!atoms.isEmpty()) {
            
            // [Step 1] 원자 이동 및 범위 밖 삭제
            for (int i = 0; i < atoms.size(); i++) {
                Atom a = atoms.get(i);
                a.x += dx[a.dir];
                a.y += dy[a.dir];

                // 범위를 벗어나면 즉시 리스트에서 제거
                if (a.x < 0 || a.x > 4000 || a.y < 0 || a.y > 4000) {
                    atoms.remove(i);
                    i--; // 인덱스 조정
                }
            }

            // [Step 2] 맵에 에너지 기록 (충돌 감지용)
            // 현재 살아남은 모든 원자의 위치에 에너지를 더함
            for (Atom a : atoms) {
                map[a.y][a.x] += a.energy;
            }

            // [Step 3] 충돌 판정 (삭제할 원자 수집)
            ArrayList<Atom> toRemove = new ArrayList<>();
            
            for (Atom a : atoms) {
                // 내 위치의 맵 값이 내 에너지와 다르다면? 
                // -> 누군가와 합쳐졌다는 뜻 (충돌 발생)
                if (map[a.y][a.x] != a.energy) {
                    totalEnergy += a.energy; // 결과에 누적
                    toRemove.add(a);         // 삭제 명단에 추가
                }
            }

            // [Step 4] 맵 초기화 (가장 중요)
            // 다음 턴을 위해 이번에 사용한 모든 좌표를 0으로 되돌려야 함.
            // 삭제될 원자든 아니든, 기록했던 자리는 모두 지워야 깨끗해짐.
            for (Atom a : atoms) {
                map[a.y][a.x] = 0;
            }

            // [Step 5] 원자 일괄 삭제
            // 리스트에서 충돌한 원자들을 한 번에 제거
            atoms.removeAll(toRemove);
        }
    }
}