<template>
  <div class="login-container">
    <div class="login-card">
      <h1>アカウントにログイン</h1>
      <form class="login-form">
        <div class="form-group">
          <label for="username">ユーザー名 </label>
          <input type="text" id="username" name="username" placeholder="ユーザー名" required />
        </div>

        <div class="form-group">
          <label for="email">メールアドレス</label>
          <input type="email" id="email" name="email" placeholder="メールアドレス" required />
        </div>

        <div class="form-group">
          <label for="password">パスワード</label>
          <input type="password" id="password" name="password" placeholder="パスワード" required />
        </div>

        <button type="submit" class="login-button">ログイン</button>
      </form>

      <div class="login-footer">
        <a href="#">パスワードをお忘れですか？</a>
        <p>アカウントをお持ちでない方は <a href="#">新規登録</a></p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f5f5;
}

.login-card {
  width: 100%;
  max-width: 400px;
  padding: 2rem;
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h1 {
  margin-bottom: 1.5rem;
  text-align: center;
  color: #333;
  font-weight: 500;
}

.login-form {
  display: flex;
  flex-direction: column;
  gap: 1.2rem;
}

.form-group {
  display: flex;
  flex-direction: column;
}

label {
  margin-bottom: 0.5rem;
  font-size: 0.9rem;
  color: #555;
}

input {
  padding: 0.8rem;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 1rem;
  transition: border-color 0.3s;
}

input:focus {
  border-color: #4a90e2;
  outline: none;
  box-shadow: 0 0 0 2px rgba(74, 144, 226, 0.2);
}

.login-button {
  margin-top: 1rem;
  padding: 0.8rem;
  background-color: #4a90e2;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  font-weight: 500;
  cursor: pointer;
  transition: background-color 0.3s;
}

.login-button:hover {
  background-color: #3a7bc8;
}

.login-footer {
  margin-top: 1.5rem;
  text-align: center;
  font-size: 0.9rem;
  color: #666;
}

.login-footer a {
  color: #4a90e2;
  text-decoration: none;
}

.login-footer a:hover {
  text-decoration: underline;
}
</style>
