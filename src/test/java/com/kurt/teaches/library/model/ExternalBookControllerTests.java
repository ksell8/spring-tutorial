package com.kurt.teaches.library.model;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExternalBookControllerTests {
  private String example = """
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="preload" as="image" href="https://images.isbndb.com/covers/45/52/9781487004552.jpg">
    <!-- Google tag (gtag.js) new -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-5CHMRHP5D2"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
      function gtag(){dataLayer.push(arguments);}
      gtag('js', new Date());

      gtag('config', 'G-5CHMRHP5D2');
      gtag('config', 'UA-23560130-1');
    </script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ISBN 9781487004552 - Power Politics: Poems (A List)</title>
    <meta name="description"
        content="Power Politics: Poems (A List) - Information and prices for ISBN 9781487004552, ISBN 1487004559">
    <meta name="canonical" content="https://isbnsearch.org/isbn/9781487004552">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="icon" type="image/x-icon" href="/images/favicon-32x32.png">
</head>

<body>
    <div id="page">
        <header>
            <p><a href="/" title="ISBN Search">ISBN Search</a></p>
        </header>
        <form id="search" action="/search" method="post">
            <div>
                <label id="find" for="searchQuery">Find a book:</label>
                <input id="searchQuery" name="searchQuery" type="text" class="start" onfocus="if(this.value=='Enter the ISBN, Title, or Author') { this.value=''; this.className=''; }" onblur="if(this.value=='') { this.value='Enter the ISBN, Title, or Author'; this.className='start'; }" value="Enter the ISBN, Title, or Author">
            </div>
            <button type="submit" id="searchSubmit" name="searchSubmit" class="btn">Search</button>
        </form>
        <div id="book">
            <div class="image">
                <img src="https://images.isbndb.com/covers/45/52/9781487004552.jpg" alt="Power Politics: Poems (A List)">
            </div>
            <div class="bookinfo">
                <h1>Power Politics: Poems (A List)</h1>
                <p><strong>ISBN-13:</strong> <a href="/isbn/9781487004552">9781487004552</a></p>
                <p><strong>ISBN-10:</strong> <a href="/isbn/1487004559">1487004559</a></p>
                <p><strong>Author:</strong> Margaret Atwood</p>
                <p><strong>Edition:</strong> New</p>
                <p><strong>Binding:</strong> Paperback</p>
                <p><strong>Publisher:</strong> A List</p>
                <p><strong>Published:</strong> 2018-03-06</p>
                <p>
                    <a class="special-link" href="https://bookscouter.com/book/9781487004552" target="_blank">Sell this
                        book</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="special-link"
                        href="https://www.campusbooks.com/search/9781487004552?buysellrent=buy&popup"
                        target="_blank">Buy or Rent?</a>
                </p>
            </div>
            <p class="clear"></p>
        </div>
        <div class="prices">
            <h2>Best Prices for this Book in New Condition</h2>
            <ul>
                <li>
                    <div class="merchant">
                        <a rel="nofollow" target="_blank"
                            href="/book?loc=0_X1U9CDHNzLR_ILcDqW3Y1iP6jNNa6g8o86uR-6QurL5mH-9onndNu95piXfj9d7bJRbeGb_xiSBXobPoQNnlcqqGjo0k6XA9XCjuJ9NTluLuaUsytSx0XfN-VNe2AmMFEFiaTe0n5KRwAtICnAGVWyYCmqdF0oP3aAHuyDi2te1VKwRZUETWVNfFhfYYzlfb3BS_IDJ9zPBWyWZEUcmfTG90BDMQa94V-Iv8VO194lGWvSMTtWsNGbvfxxS-gI"><img loading="lazy" src="/images/merchants/24.png" alt="Amazon Mkt Used" width="200px" height="200px"></a>
                    </div>
                    <div class="info">
                        <div class="price">
                            <p class="pricelink"><a rel="nofollow" target="_blank"
                                    href="/book?loc=0_X1U9CDHNzLR_ILcDqW3Y1iP6jNNa6g8o86uR-6QurL5mH-9onndNu95piXfj9d7bJRbeGb_xiSBXobPoQNnlcqqGjo0k6XA9XCjuJ9NTluLuaUsytSx0XfN-VNe2AmMFEFiaTe0n5KRwAtICnAGVWyYCmqdF0oP3aAHuyDi2te1VKwRZUETWVNfFhfYYzlfb3BS_IDJ9zPBWyWZEUcmfTG90BDMQa94V-Iv8VO194lGWvSMTtWsNGbvfxxS-gI">$10.59</a>
                            </p>
                            <p class="shipping">Free shipping</p>
                            <p class="status"></p>
                        </div>
                        <div class="notes" style="visibility: hidden;">
                            <p class="tip" title="None" rel="tooltip">Notes</p>
                        </div>
                        <div class="buylink"><a class="btn view" rel="nofollow" target="_blank"
                                href="/book?loc=0_X1U9CDHNzLR_ILcDqW3Y1iP6jNNa6g8o86uR-6QurL5mH-9onndNu95piXfj9d7bJRbeGb_xiSBXobPoQNnlcqqGjo0k6XA9XCjuJ9NTluLuaUsytSx0XfN-VNe2AmMFEFiaTe0n5KRwAtICnAGVWyYCmqdF0oP3aAHuyDi2te1VKwRZUETWVNfFhfYYzlfb3BS_IDJ9zPBWyWZEUcmfTG90BDMQa94V-Iv8VO194lGWvSMTtWsNGbvfxxS-gI">Buy
                                this book &rsaquo;</a></div>
                    </div>
                </li>
                <li>
                    <div class="merchant">
                        <a rel="nofollow" target="_blank"
                            href="/book?loc=f_D6x1EDW0fdjG_bZKOJ2XfUEYskU9ukRQ-dJcaNfa9w6apIPkMnTWNJgvF7kb7YqhXeDayWCRTB5Qb9thS-fiTpJqq6hKW_l6xvF6vGzppAyVy7XtDFSnHvwyiJJulTVA_EwP0md4LzfvhC3MiknV3hbAzThnttv40dlr84TP4KzVvfIV6d0uM1O-QqvirRYYRK2HZeorYt3Y03ytMmVmVONSC_CqYn-BqH8u7EJw-pRCJjnePU7VZx7JcGmSlgrNWnsMGoZ1np6zL5tb59YfZghw7AUn4MjqEfpo1rTbhyXvBvnLT4hoOUhPsRquPvZNdmoXeWqXfPelfg2SIy-_K9Yu6AYB46XwiSDgD-MyJI4ts938RHPtk4WoVIu9l7GzTUnAEhhl_DKy1ilUFE5LK_FOquvuh0aQ238s4nzzp-VqiR5uE1Hca0iBRfFC99bo48KgimNNxpcrlqaa81XA"><img loading="lazy" src="/images/merchants/23.png" alt="Alibris.com" width="200px" height="200px"></a>
                    </div>
                    <div class="info">
                        <div class="price">
                            <p class="pricelink"><a rel="nofollow" target="_blank"
                                    href="/book?loc=f_D6x1EDW0fdjG_bZKOJ2XfUEYskU9ukRQ-dJcaNfa9w6apIPkMnTWNJgvF7kb7YqhXeDayWCRTB5Qb9thS-fiTpJqq6hKW_l6xvF6vGzppAyVy7XtDFSnHvwyiJJulTVA_EwP0md4LzfvhC3MiknV3hbAzThnttv40dlr84TP4KzVvfIV6d0uM1O-QqvirRYYRK2HZeorYt3Y03ytMmVmVONSC_CqYn-BqH8u7EJw-pRCJjnePU7VZx7JcGmSlgrNWnsMGoZ1np6zL5tb59YfZghw7AUn4MjqEfpo1rTbhyXvBvnLT4hoOUhPsRquPvZNdmoXeWqXfPelfg2SIy-_K9Yu6AYB46XwiSDgD-MyJI4ts938RHPtk4WoVIu9l7GzTUnAEhhl_DKy1ilUFE5LK_FOquvuh0aQ238s4nzzp-VqiR5uE1Hca0iBRfFC99bo48KgimNNxpcrlqaa81XA">$9.59</a>
                            </p>
                            <p class="shipping">+4.49 shipping</p>
                            <p class="status"></p>
                        </div>
                        <div class="notes" style="">
                            <p class="tip" title="9781487004552. BRAND NEW" rel="tooltip">Notes</p>
                        </div>
                        <div class="buylink"><a class="btn view" rel="nofollow" target="_blank"
                                href="/book?loc=f_D6x1EDW0fdjG_bZKOJ2XfUEYskU9ukRQ-dJcaNfa9w6apIPkMnTWNJgvF7kb7YqhXeDayWCRTB5Qb9thS-fiTpJqq6hKW_l6xvF6vGzppAyVy7XtDFSnHvwyiJJulTVA_EwP0md4LzfvhC3MiknV3hbAzThnttv40dlr84TP4KzVvfIV6d0uM1O-QqvirRYYRK2HZeorYt3Y03ytMmVmVONSC_CqYn-BqH8u7EJw-pRCJjnePU7VZx7JcGmSlgrNWnsMGoZ1np6zL5tb59YfZghw7AUn4MjqEfpo1rTbhyXvBvnLT4hoOUhPsRquPvZNdmoXeWqXfPelfg2SIy-_K9Yu6AYB46XwiSDgD-MyJI4ts938RHPtk4WoVIu9l7GzTUnAEhhl_DKy1ilUFE5LK_FOquvuh0aQ238s4nzzp-VqiR5uE1Hca0iBRfFC99bo48KgimNNxpcrlqaa81XA">Buy
                                this book &rsaquo;</a></div>
                    </div>
                </li>
                <li>
                    <div class="merchant">
                        <a rel="nofollow" target="_blank"
                            href="/book?loc=RdliZ9skYhAX8QSJ5MTEmoLWeW7RRLOmuR90QRRkwNFhnbjwDZMyT0OSjXcAzlDLu1qPtWBc6LWP09ZogdCVYg5AxfOlfH4cLXKjlKAKXoQBypCNUP4M81FmqY2rSS0EJxbSOlnfiBj-zoM-tgS2NFNaBlyOrw3zyVmM0pYN6QvpJKPfaBZ_oEVROZ7EUVJs16Q4A7RwO2qmLX8V-Xw4mK-yJ6RyCnuw7sHYNB-H9ZnwhHw-ACwvuZ-MxgDbZ6W4oSmGycTOSw3bczYLQnbanh09WuVzYHYZnHSbgfjFeH3ZB5kmo1bDGg0GaQex1WQF-7kWuAjGzMt00C2N5sASeTik96wdCqgFtwZh0X1I2t2Y8PH5RPuUUux-Mq9Fxzt4"><img loading="lazy" src="/images/merchants/35.png" alt="Textbookrush" width="200px" height="200px"></a>
                    </div>
                    <div class="info">
                        <div class="price">
                            <p class="pricelink"><a rel="nofollow" target="_blank"
                                    href="/book?loc=RdliZ9skYhAX8QSJ5MTEmoLWeW7RRLOmuR90QRRkwNFhnbjwDZMyT0OSjXcAzlDLu1qPtWBc6LWP09ZogdCVYg5AxfOlfH4cLXKjlKAKXoQBypCNUP4M81FmqY2rSS0EJxbSOlnfiBj-zoM-tgS2NFNaBlyOrw3zyVmM0pYN6QvpJKPfaBZ_oEVROZ7EUVJs16Q4A7RwO2qmLX8V-Xw4mK-yJ6RyCnuw7sHYNB-H9ZnwhHw-ACwvuZ-MxgDbZ6W4oSmGycTOSw3bczYLQnbanh09WuVzYHYZnHSbgfjFeH3ZB5kmo1bDGg0GaQex1WQF-7kWuAjGzMt00C2N5sASeTik96wdCqgFtwZh0X1I2t2Y8PH5RPuUUux-Mq9Fxzt4">$11.57</a>
                            </p>
                            <p class="shipping">+2.99 shipping</p>
                            <p class="status"></p>
                        </div>
                        <div class="notes" style="">
                            <p class="tip" title="9781487004552." rel="tooltip">Notes</p>
                        </div>
                        <div class="buylink"><a class="btn view" rel="nofollow" target="_blank"
                                href="/book?loc=RdliZ9skYhAX8QSJ5MTEmoLWeW7RRLOmuR90QRRkwNFhnbjwDZMyT0OSjXcAzlDLu1qPtWBc6LWP09ZogdCVYg5AxfOlfH4cLXKjlKAKXoQBypCNUP4M81FmqY2rSS0EJxbSOlnfiBj-zoM-tgS2NFNaBlyOrw3zyVmM0pYN6QvpJKPfaBZ_oEVROZ7EUVJs16Q4A7RwO2qmLX8V-Xw4mK-yJ6RyCnuw7sHYNB-H9ZnwhHw-ACwvuZ-MxgDbZ6W4oSmGycTOSw3bczYLQnbanh09WuVzYHYZnHSbgfjFeH3ZB5kmo1bDGg0GaQex1WQF-7kWuAjGzMt00C2N5sASeTik96wdCqgFtwZh0X1I2t2Y8PH5RPuUUux-Mq9Fxzt4">Buy
                                this book &rsaquo;</a></div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="prices">
            <h2>Best Used Prices</h2>
            <ul>
                <li>
                    <div class="merchant">
                        <a rel="nofollow" target="_blank"
                            href="/book?loc=0_X1U9CDHNzLR_ILcDqW3Y1iP6jNNa6g8o86uR-6QurL5mH-9onndNu95piXfj9d7bJRbeGb_xiSBXobPoQNnlcqqGjo0k6XA9XCjuJ9NTluLuaUsytSx0XfN-VNe2AmEXBpb0mjSDBr9notoZaSMMnMAORZanF5bTbboEL9wPOSrprr0__CcqI35uEwOjob_SQ84i-6tC9Da6agfDjSvK2vhGM3ig_x2SSS7r1JYsJ-rKQMAemazjMJGAL9ES3v"><img loading="lazy" src="/images/merchants/24.png" alt="Amazon Mkt Used" width="200px" height="200px"></a>
                    </div>
                    <div class="info">
                        <div class="price">
                            <p class="pricelink"><a rel="nofollow" target="_blank"
                                    href="/book?loc=0_X1U9CDHNzLR_ILcDqW3Y1iP6jNNa6g8o86uR-6QurL5mH-9onndNu95piXfj9d7bJRbeGb_xiSBXobPoQNnlcqqGjo0k6XA9XCjuJ9NTluLuaUsytSx0XfN-VNe2AmEXBpb0mjSDBr9notoZaSMMnMAORZanF5bTbboEL9wPOSrprr0__CcqI35uEwOjob_SQ84i-6tC9Da6agfDjSvK2vhGM3ig_x2SSS7r1JYsJ-rKQMAemazjMJGAL9ES3v">$5.43</a>
                            </p>
                            <p class="shipping">+3.99 shipping</p>
                            <p class="status"></p>
                        </div>
                        <div class="notes" style="visibility: hidden;">
                            <p class="tip" title="None" rel="tooltip">Notes</p>
                        </div>
                        <div class="buylink"><a class="btn view" rel="nofollow" target="_blank"
                                href="/book?loc=0_X1U9CDHNzLR_ILcDqW3Y1iP6jNNa6g8o86uR-6QurL5mH-9onndNu95piXfj9d7bJRbeGb_xiSBXobPoQNnlcqqGjo0k6XA9XCjuJ9NTluLuaUsytSx0XfN-VNe2AmEXBpb0mjSDBr9notoZaSMMnMAORZanF5bTbboEL9wPOSrprr0__CcqI35uEwOjob_SQ84i-6tC9Da6agfDjSvK2vhGM3ig_x2SSS7r1JYsJ-rKQMAemazjMJGAL9ES3v">Buy
                                this book &rsaquo;</a></div>
                    </div>
                </li>
                <li>
                    <div class="merchant">
                        <a rel="nofollow" target="_blank"
                            href="/book?loc=-L3OyYvtIyMGcM_vUZd4ra4GxIveUvRc9QJwltPKG-5E4Wmpt0sMy2dhGcRr2c1Q5-eYac1eiBv04nUQqwxMSbR0R_z0-Ob0q-V_jUrfxiMKI5cmaxzAkG0ZkqnF2Qv8PycdsNH-uTSb7WTVarAIy_IPTvj4wDYbP09sPezCRkg-5AljpvFX0GveZULs0HMfNZVg8O7FXBeSZixwsYMmz3natmP2czZPvOV2zghqMEtcFwGPthLWVDMT8PiB0IP6tkCD5wQX4wPHNTlsgTi9kcyQbOI75GGakEiCxmmtrBHd_OkKhOWRdFMRi0PXCOy9f10rs5udRQ8Mql3bhHFrpw9BX00qBBF8QCLU6IqyAX1Sh3Mir92rwh-_Fo7FS2Au"><img loading="lazy" src="/images/merchants/2023.png" alt="AbeBooks.com Used" width="200px" height="200px"></a>
                    </div>
                    <div class="info">
                        <div class="price">
                            <p class="pricelink"><a rel="nofollow" target="_blank"
                                    href="/book?loc=-L3OyYvtIyMGcM_vUZd4ra4GxIveUvRc9QJwltPKG-5E4Wmpt0sMy2dhGcRr2c1Q5-eYac1eiBv04nUQqwxMSbR0R_z0-Ob0q-V_jUrfxiMKI5cmaxzAkG0ZkqnF2Qv8PycdsNH-uTSb7WTVarAIy_IPTvj4wDYbP09sPezCRkg-5AljpvFX0GveZULs0HMfNZVg8O7FXBeSZixwsYMmz3natmP2czZPvOV2zghqMEtcFwGPthLWVDMT8PiB0IP6tkCD5wQX4wPHNTlsgTi9kcyQbOI75GGakEiCxmmtrBHd_OkKhOWRdFMRi0PXCOy9f10rs5udRQ8Mql3bhHFrpw9BX00qBBF8QCLU6IqyAX1Sh3Mir92rwh-_Fo7FS2Au">$14.27</a>
                            </p>
                            <p class="shipping">Free shipping</p>
                            <p class="status"></p>
                        </div>
                        <div class="notes" style="">
                            <p class="tip"
                                title="Buy with confidence! Book is in good condition with minor wear to the pages, binding, and minor marks within 0.22"
                                rel="tooltip">Notes</p>
                        </div>
                        <div class="buylink"><a class="btn view" rel="nofollow" target="_blank"
                                href="/book?loc=-L3OyYvtIyMGcM_vUZd4ra4GxIveUvRc9QJwltPKG-5E4Wmpt0sMy2dhGcRr2c1Q5-eYac1eiBv04nUQqwxMSbR0R_z0-Ob0q-V_jUrfxiMKI5cmaxzAkG0ZkqnF2Qv8PycdsNH-uTSb7WTVarAIy_IPTvj4wDYbP09sPezCRkg-5AljpvFX0GveZULs0HMfNZVg8O7FXBeSZixwsYMmz3natmP2czZPvOV2zghqMEtcFwGPthLWVDMT8PiB0IP6tkCD5wQX4wPHNTlsgTi9kcyQbOI75GGakEiCxmmtrBHd_OkKhOWRdFMRi0PXCOy9f10rs5udRQ8Mql3bhHFrpw9BX00qBBF8QCLU6IqyAX1Sh3Mir92rwh-_Fo7FS2Au">Buy
                                this book &rsaquo;</a></div>
                    </div>
                </li>
                <li>
                    <div class="merchant">
                        <a rel="nofollow" target="_blank"
                            href="/book?loc=f_D6x1EDW0fdjG_bZKOJ2XfUEYskU9ukRQ-dJcaNfa9w6apIPkMnTWNJgvF7kb7YqhXeDayWCRTB5Qb9thS-fiTpJqq6hKW_l6xvF6vGzppAyVy7XtDFSnHvwyiJJulTVA_EwP0md4LzfvhC3MiknV3hbAzThnttv40dlr84TP4KzVvfIV6d0uM1O-QqvirRYYRK2HZeorYt3Y03ytMmVmVONSC_CqYn-BqH8u7EJw-pRCJjnePU7VZx7JcGmSlgrNWnsMGoZ1np6zL5tb59YfZghw7AUn4MjqEfpo1rTbgXNo7WbRyv8HlSmy2nGv7jFwesVVIHYElas4GtvkB-9PK9Yu6AYB46XwiSDgD-MyJI4ts938RHPtk4WoVIu9l7GzTUnAEhhl_DKy1ilUFE5LK_FOquvuh0aQ238s4nzzrhRdQQbJqC3l184d7D-r3VadRvTHlpF-R6cRYPYU7dHg"><img loading="lazy" src="/images/merchants/23.png" alt="Alibris.com" width="200px" height="200px"></a>
                    </div>
                    <div class="info">
                        <div class="price">
                            <p class="pricelink"><a rel="nofollow" target="_blank"
                                    href="/book?loc=f_D6x1EDW0fdjG_bZKOJ2XfUEYskU9ukRQ-dJcaNfa9w6apIPkMnTWNJgvF7kb7YqhXeDayWCRTB5Qb9thS-fiTpJqq6hKW_l6xvF6vGzppAyVy7XtDFSnHvwyiJJulTVA_EwP0md4LzfvhC3MiknV3hbAzThnttv40dlr84TP4KzVvfIV6d0uM1O-QqvirRYYRK2HZeorYt3Y03ytMmVmVONSC_CqYn-BqH8u7EJw-pRCJjnePU7VZx7JcGmSlgrNWnsMGoZ1np6zL5tb59YfZghw7AUn4MjqEfpo1rTbgXNo7WbRyv8HlSmy2nGv7jFwesVVIHYElas4GtvkB-9PK9Yu6AYB46XwiSDgD-MyJI4ts938RHPtk4WoVIu9l7GzTUnAEhhl_DKy1ilUFE5LK_FOquvuh0aQ238s4nzzrhRdQQbJqC3l184d7D-r3VadRvTHlpF-R6cRYPYU7dHg">$12.48</a>
                            </p>
                            <p class="shipping">+4.49 shipping</p>
                            <p class="status"></p>
                        </div>
                        <div class="notes" style="">
                            <p class="tip"
                                title="Trade paperback (US). Glued binding. 72 p. List. In Stock. 100% Money Back Guarantee. Brand New, Perfect Condition, allow 4-14 business days for standard shipping. To Alaska, Hawaii, U.S. protectorate, P.O. box, and APO/FPO addresses allow 4-28 business days for Standard shipping. No expedited shipping. All orders placed with expedited shipping will be cancelled. Over 3, 000, 000 happy customers. Fine."
                                rel="tooltip">Notes</p>
                        </div>
                        <div class="buylink"><a class="btn view" rel="nofollow" target="_blank"
                                href="/book?loc=f_D6x1EDW0fdjG_bZKOJ2XfUEYskU9ukRQ-dJcaNfa9w6apIPkMnTWNJgvF7kb7YqhXeDayWCRTB5Qb9thS-fiTpJqq6hKW_l6xvF6vGzppAyVy7XtDFSnHvwyiJJulTVA_EwP0md4LzfvhC3MiknV3hbAzThnttv40dlr84TP4KzVvfIV6d0uM1O-QqvirRYYRK2HZeorYt3Y03ytMmVmVONSC_CqYn-BqH8u7EJw-pRCJjnePU7VZx7JcGmSlgrNWnsMGoZ1np6zL5tb59YfZghw7AUn4MjqEfpo1rTbgXNo7WbRyv8HlSmy2nGv7jFwesVVIHYElas4GtvkB-9PK9Yu6AYB46XwiSDgD-MyJI4ts938RHPtk4WoVIu9l7GzTUnAEhhl_DKy1ilUFE5LK_FOquvuh0aQ238s4nzzrhRdQQbJqC3l184d7D-r3VadRvTHlpF-R6cRYPYU7dHg">Buy
                                this book &rsaquo;</a></div>
                    </div>
                </li>
                <li>
                    <div class="merchant">
                        <a rel="nofollow" target="_blank"
                            href="/book?loc=RdliZ9skYhAX8QSJ5MTEmoLWeW7RRLOmuR90QRRkwNFhnbjwDZMyT0OSjXcAzlDLu1qPtWBc6LWP09ZogdCVYl20pc6cm_Ivee2sFypF72FVHQ7uacWUI8A1g6vxMYFJJxbSOlnfiBj-zoM-tgS2NFNaBlyOrw3zyVmM0pYN6QvpJKPfaBZ_oEVROZ7EUVJs16Q4A7RwO2qmLX8V-Xw4mK-yJ6RyCnuw7sHYNB-H9ZnwhHw-ACwvuZ-MxgDbZ6W4oSmGycTOSw3bczYLQnbanh09WuVzYHYZnHSbgfjFeH3ZB5kmo1bDGg0GaQex1WQF-7kWuAjGzMt00C2N5sASeT82nmpGncfDpWdcbh6EAomICyQ2OJeez6WVySt4SPME"><img loading="lazy" src="/images/merchants/35.png" alt="Textbookrush" width="200px" height="200px"></a>
                    </div>
                    <div class="info">
                        <div class="price">
                            <p class="pricelink"><a rel="nofollow" target="_blank"
                                    href="/book?loc=RdliZ9skYhAX8QSJ5MTEmoLWeW7RRLOmuR90QRRkwNFhnbjwDZMyT0OSjXcAzlDLu1qPtWBc6LWP09ZogdCVYl20pc6cm_Ivee2sFypF72FVHQ7uacWUI8A1g6vxMYFJJxbSOlnfiBj-zoM-tgS2NFNaBlyOrw3zyVmM0pYN6QvpJKPfaBZ_oEVROZ7EUVJs16Q4A7RwO2qmLX8V-Xw4mK-yJ6RyCnuw7sHYNB-H9ZnwhHw-ACwvuZ-MxgDbZ6W4oSmGycTOSw3bczYLQnbanh09WuVzYHYZnHSbgfjFeH3ZB5kmo1bDGg0GaQex1WQF-7kWuAjGzMt00C2N5sASeT82nmpGncfDpWdcbh6EAomICyQ2OJeez6WVySt4SPME">$14.60</a>
                            </p>
                            <p class="shipping">+2.99 shipping</p>
                            <p class="status"></p>
                        </div>
                        <div class="notes" style="">
                            <p class="tip"
                                title="Trade paperback (US). Glued binding. 72 p. List. In Stock. 100% Money Back Guarantee. Brand New, Perfect Condition, allow 4-14 business days for standard shipping. To Alaska, Hawaii, U.S. protectorate, P.O. box, and APO/FPO addresses allow 4-28 business days for Standard shipping. No expedited shipping. All orders placed with expedited shipping will be cancelled. Over 3, 000, 000 happy customers."
                                rel="tooltip">Notes</p>
                        </div>
                        <div class="buylink"><a class="btn view" rel="nofollow" target="_blank"
                                href="/book?loc=RdliZ9skYhAX8QSJ5MTEmoLWeW7RRLOmuR90QRRkwNFhnbjwDZMyT0OSjXcAzlDLu1qPtWBc6LWP09ZogdCVYl20pc6cm_Ivee2sFypF72FVHQ7uacWUI8A1g6vxMYFJJxbSOlnfiBj-zoM-tgS2NFNaBlyOrw3zyVmM0pYN6QvpJKPfaBZ_oEVROZ7EUVJs16Q4A7RwO2qmLX8V-Xw4mK-yJ6RyCnuw7sHYNB-H9ZnwhHw-ACwvuZ-MxgDbZ6W4oSmGycTOSw3bczYLQnbanh09WuVzYHYZnHSbgfjFeH3ZB5kmo1bDGg0GaQex1WQF-7kWuAjGzMt00C2N5sASeT82nmpGncfDpWdcbh6EAomICyQ2OJeez6WVySt4SPME">Buy
                                this book &rsaquo;</a></div>
                    </div>
                </li>
            </ul>
        </div>











        <p class="disclaimer">As an Amazon Associate we earn from qualifying purchases.</p>
    </div>
    <!--page-->
    <footer>
        <ul>
            <li>Copyright &copy; 2008-2024 <a href="/">ISBNsearch.org</a></li>
            <li><button class="btn-link" onclick="window.location.href=atob('bWFpbHRvOmNvbnRhY3RAaXNibnNlYXJjaC5vcmc=')">contact[at]isbnsearch.org</button>
            </li>
            <li><a href="/privacy">Privacy</a></li>
        </ul>
        <p class="note">This website is an independent service and is not affiliated with The International ISBN Agency
            Limited or any other national ISBN registration agency.</p>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/tips.js"></script>
</body>

</html>
          """;

  @Test
  void testInformationIsParsed(){
    Document doc = Jsoup.parse(example);
    Element bookInfoDiv = doc.select("div.bookinfo").first();
    assert(bookInfoDiv != null);

    // check data is as expected
    Map<String, Object> bookDetails = ExternalBookController.parseHTMLISBNSearch(bookInfoDiv);
    assertEquals("Power Politics: Poems (A List)", bookDetails.get("title"));
    assertEquals("Margaret Atwood", ((List<String>) bookDetails.get("authors")).get(0));
    assertEquals("2018", bookDetails.get("publishedYear"));
    assertEquals("A List", bookDetails.get("publisher"));

  }


}
