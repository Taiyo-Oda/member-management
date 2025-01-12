# member-management

## アプリの起動方法

以下を実行してjava開発環境のコンテナを作成するためのイメージを作成する
```
 cd backend/
 docker build --platform linux/amd64 -t member-management-backend .
```

アプリの起動・停止は、以下のコマンドを実行して行う
```
docker-compose up -d
docker-compose down
```
