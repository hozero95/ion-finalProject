<template>

  <body>
    <hr>
    <!-- footer -->
    <footer class="footer">
      <div class="footer__left">
        <div class="footer__left__row1">
          <p><strong>(주) 5징어닷컴</strong></p>
          <p>
            <h3><i class="fas fa-headset"></i> 1577-3419</h3>
          </p>
          <p class="text2">고객센터/전자금융거래분쟁처리</p>
          <p class="text1">대표자 : 박용우 서울특별시 송파구 중대로 135 아이티벤처타워 사업자등록번호: 555-55-55555 통신판매업 신고번호: 제2020-서울종로-1154호</p>
          <p class="text1">개인정보보호책임자: 박용우 Fax: 55-5555-5555 5징어@5징어.com</p>
        </div>
        <div class="footer__left__row2">
          <p class="text2"><strong>SSG.COM 호스팅서비스 사업자 : (주)5징어닷컴</strong></p>
          <div><img src="../images/prize.png" alt=""></div>
          <p class="text2"><strong>우리은행 채무지급보증 안내</strong></p>
          <p class="text3">당사는 고객님이 현금 결제한 금액에 대해 우리은행과 채무지급보증 계약을 체결하여 안전거래를 보장하고 있습니다</p>
          <ul>
            <li></li>
          </ul>
        </div>
        <div class="footer__left__row3">
          <p class="text3">㈜5징어닷컴 사이트의 상품/판매자/쇼핑정보, 컨텐츠, UI 등에 대한 무단 복제, 전송, 배포, 스크래핑 등의 행위는 저작권법, 콘텐츠사업 진흥법 등에 의하여
            엄격히 금지됩니다. </p>
        </div>
      </div>
      <div class="footer__right">
        <div><img src="../images/qr.png" alt=""></div>
      </div>
    </footer>
  </body>
</template>

<script>
  export default {

  }
</script>

<style scoped>
  /* Universal tags */
  * {
    box-sizing: border-box;
  }

  body {
    font-family: 'Open Sans', sans-serif;
    margin: 0;
  }

  a {
    text-decoration: none;
    color: var(--color-white);
  }

  ul {
    padding-left: 0;
  }

  li {
    list-style: none;
  }

  button {
    background-color: transparent;
    cursor: pointer;
    border: none;
    outline: none;
    padding: 0;
  }

  p {
    margin: 0;
  }

  .text1 {
    margin: 0;
    font-size: 12px;
    color: gray;
  }

  .text2 {
    margin: 0;
    font-size: 12px;
  }

  .text3 {
    margin: 0;
    font-size: 11px;
    color: gray;
  }

  /* footer */
  .footer {
    width: 100%;
    height: 335px;
    padding: 0 320px;
  }

  .footer__left {
    width: 70%;
    float: left;
  }

  .footer__left__row2 {
    margin-top: 20px;
  }

  .footer__left__row2 img {
    width: 750px;
    height: 60px;
    margin-left: 0;

  }

  .footer__left__row3 {
    margin-top: 20px;
  }

  .footer__right {
    width: 30%;
    float: right;
    padding-left: 180px;
  }

  .footer__right img {
    width: 200px;
    height: 80px;
  }

  /* 노트북 사이즈 */
  @media screen and (max-width: 1500px) {
    .header {
      padding: 0 80px;
    }

    .input__header__search__input button {
      left: 387px;
      top: 57px;
    }

    .footer {
      padding: 0 90px;
    }

    .footer__right {
      padding-left: 170px;
    }
  }
</style>