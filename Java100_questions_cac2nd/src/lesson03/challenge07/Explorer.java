/**
 * 第3章 探検隊のお仕事
 *
 * 問題7  ワニが現れた
 *
 * 進行方向にワニが3匹現れました。
 * このワニはそれぞれグーワニ、チョキワニ、パーワニの何れかです。
 *
 * グーワニは手をパーかグーにして見せるとおとなしくなり、
 * チョキワニは手をグーかチョキにして見せるとおとなしくなり、
 * パーワニは手をチョキかパーにして見せるとおとなしくなるのですが、
 * この3種は外見がまったく一緒で見分けがつきません。
 * （つまり、3匹がそれぞれ1種ずつである場合も
 *   3匹ともグーワニである可能性もあります。）
 *
 * この道を通り抜けるためには、 3匹にそれぞれ勝つか引き分けるか
 * しなければなりません。負けるとその時点でチャレンジ終了となります。
 *
 * コメントの位置にwhile文とif文を利用した処理を記述して
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  隊長：
 *  ワニ3匹発見！
 *  グーワニかチョキワニかパーワニのどれかです。
 *
 *  隊長：
 *  どの手を出して通り抜けますか
 *  （グー… 1 : チョキ… 2 : パー… 3）＞2
 *
 *  隊長：
 *  相手はチョキワニでした。
 *  1匹目通り抜け成功！
 *
 *  隊長：
 *  どの手を出して通り抜けますか
 *  （グー… 1 : チョキ… 2 : パー… 3）＞3
 *
 *  隊長：
 *  相手はグーワニでした。
 *  2匹目通り抜け成功！
 *
 *  隊長：
 *  どの手を出して通り抜けますか
 *  （グー… 1 : チョキ… 2 : パー… 3）＞1
 *
 *  隊長：
 *  相手はグーワニでした。
 *  3匹目通り抜け成功！
 *
 *  隊長：
 *  川を渡り切りました。
 *
 * <通り抜けに失敗した場合の実行例>
 *  隊長：
 *  相手はグーワニでした。
 *  通り抜けに失敗しました...
 *
 * <範囲外の手が入力された場合の実行例>
 *
 *  隊長：
 *  そんな手はありませんよ。もう一度入れてください。
 *
 */

package lesson03.challenge07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Explorer {

	public static void main(String[] args) throws IOException {

		System.out.println("隊長：");
		System.out.println("ワニ3匹発見！\n");
		System.out.println("グーワニかチョキワニかパーワニのどれかです。\n");

		int Flag = 0;
		int i = 0;
		int alligator_hand = (int) (Math.random() * 10 % 3) + 1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//ここにwhile文、if文を利用した処理を記述
		//iが3になるまで実行
		while (i < 3) {
			//もしじゃんけんに負けたなら即座に最後文まで飛ぶ
			if (Flag == 1) {
				break;
			}
			System.out.println(" 隊長：\nどの手を出して通り抜けますか\n(グー… 1 : チョキ… 2 : パー… 3）＞");
			String ans = br.readLine();
			int ans_num = Integer.parseInt(ans);
			//じゃんけんワニとの判定を行う
			//グーワニ
			if (alligator_hand == 1) {
				System.out.println("相手はグーワニでした。");
				if (ans_num == 1 || ans_num == 3) {
					System.out.println(i + 1 + "匹目通り抜け成功！");
				} else {
					i = 0;
					Flag = 1;
					System.out.println("通り抜けに失敗しました。");
				}
			}

			//チョキワニ
			if (alligator_hand == 2) {
				System.out.println("相手はチョキワニでした。");
				if (ans_num == 1 || ans_num == 2) {
					System.out.println(i + 1 + "匹目通り抜け成功！");
				} else {
					i = 0;
					Flag = 1;
					System.out.println("通り抜けに失敗しました。");
				}
			}

			//パーワニ
			if (alligator_hand == 3) {
				System.out.println("相手はパーワニでした。");
				if (ans_num == 2 || ans_num == 3) {
					System.out.println(i + 1 + "匹目通り抜け成功！");
				} else {
					i = 0;
					Flag = 1;
					System.out.println("通り抜けに失敗しました。");
				}
			}
			//渡ったワニの数を加算
			i += 1;
			alligator_hand = (int) (Math.random() * 10 % 3) + 1;

		}

		if (i == 3)

		{
			System.out.println("隊長：");
			System.out.println("川を渡り切りました。");
		}

	}
}
