import jp.ne.docomo.smt.dev.common.exception.SdkException;
import jp.ne.docomo.smt.dev.common.exception.ServerException;
import jp.ne.docomo.smt.dev.common.http.AuthApiKey;
import jp.ne.docomo.smt.dev.dialogue.Dialogue;
import jp.ne.docomo.smt.dev.dialogue.data.DialogueResultData;
import jp.ne.docomo.smt.dev.dialogue.param.DialogueRequestParam;

/**
 * 雑談対話サンプルコード
 */
public class DialogueSample {

	public static void main(String[] args) {

		try {
			// APIKEY の設定
			AuthApiKey
					.initializeAuth("46676a386f614a4a635566524476383144526c4a3159315a392e45316e3574792e4f437065483574633839");

			// プロキシの設定
			// プロキシを使用しない場合はコメントにしてください
			// ProxyInfo.initializeProxy("proxyhost.co.jp", 80);

			// 雑談対話パラメータクラスを生成して、質問を設定する
			DialogueRequestParam param = new DialogueRequestParam();
			param.setUtt("本の名前はなんですか");
			param.setContext("aaabbbccc111222333");
			param.setNickname("光");
			param.setNickname_y("ヒカリ");
			param.setSex("女");
			param.setBloodtype("B");
			param.setBirthdateY(1997);
			param.setBirthdateM(5);
			param.setBirthdateD(30);
			param.setAge(16);
			param.setConstellations("双子座");
			param.setPlace("東京");
			param.setMode("dialog");
			param.setCharacter(30);

			// 雑談対話クラスの生成して、リクエストを実行する
			Dialogue dialogue = new Dialogue();
			DialogueResultData resultData = dialogue.request(param);

			// 返却するメッセージに関する情報の出力
			System.out.println("システムの返答 : " + resultData.getUtt());
			System.out.println("音声合成用読み出力 : " + resultData.getYomi());
			System.out.println("モード : " + resultData.getMode());
			System.out.println("対話番号 : " + resultData.getDa());
			System.out.println("コンテキストID : " + resultData.getContext());

		} catch (SdkException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
	}
}
