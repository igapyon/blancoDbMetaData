blancoDbMetaData は データベースのメタ情報を取得するためのツールです。
blancoDb プロダクトの中枢をになうサブプロジェクトでもあります。

[仕様]
 1.指定されたデータベース内のテーブル一覧やテーブルの列名、型情報などを JDBC ドライバを経由して取得できます。
 2.取得されたメタ情報はバリューオブジェクトに格納したりCSVファイルに出力することができます。

[利用上のポイント]
 1.SQL Server 2000に接続する際には、SQL Server 2005のJDBCドライバを利用することを推奨します。

[開発者]
 1.伊賀敏樹 (Tosiki Iga / いがぴょん): 開発および維持メンテ担当
 2.山本耕司 (ymoto) : 仕様決定およびリリース判定担当

[ライセンス]
 1.blancoDbMetaData は ライセンス として GNU Lesser General Public License を採用しています。

[依存するライブラリ]
blancoDbMetaDataは下記のライブラリを利用しています。
※各オープンソース・プロダクトの提供者に感謝します。
 1.JExcelApi - Java Excel API - A Java API to read, write and modify Excel spreadsheets
     http://jexcelapi.sourceforge.net/
     http://sourceforge.net/projects/jexcelapi/
     http://www.andykhan.com/jexcelapi/ 
   概要: JavaからExcelブック形式を読み書きするためのライブラリです。
   ライセンス: GNU Lesser General Public License
 2.blancoCg
   概要: ソースコード生成ライブラリ
   ライセンス: GNU Lesser General Public License
 3.その他の blanco Framework
   概要: このプロダクトは それ自身が blanco Frameworkにより自動生成されています。
         このプロダクトは 実行時に blanco Framework各種プロダクトに依存して動作します。
   ライセンス: GNU Lesser General Public License
