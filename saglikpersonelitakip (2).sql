-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 05 Haz 2020, 11:49:31
-- Sunucu sürümü: 5.7.17-log
-- PHP Sürümü: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `saglikpersonelitakip`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `adres`
--

CREATE TABLE `adres` (
  `adres_id` int(11) NOT NULL,
  `hasta_id` int(11) NOT NULL,
  `adres` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `adres`
--

INSERT INTO `adres` (`adres_id`, `hasta_id`, `adres`) VALUES
(1, 2, 'asdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasdasdsadsadasdsadsadsadasdasd');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bossaatler`
--

CREATE TABLE `bossaatler` (
  `bossaatler_id` int(11) NOT NULL,
  `personel_id` int(11) NOT NULL,
  `pazartesi` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `sali` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `carsamba` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `persembe` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `cuma` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `cumartesi` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `pazar` varchar(250) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `bossaatler`
--

INSERT INTO `bossaatler` (`bossaatler_id`, `personel_id`, `pazartesi`, `sali`, `carsamba`, `persembe`, `cuma`, `cumartesi`, `pazar`) VALUES
(1, 77, '14.00-18.30', '15.30-17.00', '-', '12.00-18.00', '14.00-18.30', '09.00-17.00', '-'),
(24, 58, '15.00-19.00', '12.00-15.00', '08.00-17.00', '09.00-12.00', '09.00-15.00', '18.00-19.00', ''),
(25, 0, '4', '4', '4', '4', '4', '4', '4'),
(26, 0, '4', '4', '4', '4', '4', '4', '4');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `brans`
--

CREATE TABLE `brans` (
  `brans_id` int(11) NOT NULL,
  `brans` varchar(250) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `brans`
--

INSERT INTO `brans` (`brans_id`, `brans`) VALUES
(1, 'Doktor'),
(2, 'Hemişer'),
(3, 'Hasta Bakıcı');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `file`
--

CREATE TABLE `file` (
  `id` int(11) NOT NULL,
  `filePath` varchar(1000) COLLATE utf8_turkish_ci NOT NULL,
  `fileName` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `fileType` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `personel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `file`
--

INSERT INTO `file` (`id`, `filePath`, `fileName`, `fileType`, `personel_id`) VALUES
(7, 'C:UsersMetehanDesktopupload', 'banner.jpg', 'image/jpeg', 77),
(8, 'C:UsersMetehanDesktopupload', '1.jpg', 'image/jpeg', 78),
(9, 'C:UsersMetehanDesktopupload', '2.jpg', 'image/jpeg', 79);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hasta_kayit`
--

CREATE TABLE `hasta_kayit` (
  `hasta_id` int(11) NOT NULL,
  `hasta_ad` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `hasta_soyad` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `hasta_aciklama` varchar(250) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `hasta_kayit`
--

INSERT INTO `hasta_kayit` (`hasta_id`, `hasta_ad`, `hasta_soyad`, `hasta_aciklama`) VALUES
(2, 'Mehmet', 'yılmaz', 'iğne vurulacak'),
(3, 'ahmet', 'çakır', 'istenilen saatlerde doktor veya hemşire tarafından iğne vurulacak');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ihtiyac_saati`
--

CREATE TABLE `ihtiyac_saati` (
  `ihtiyac_id` int(11) NOT NULL,
  `hasta_id` int(11) NOT NULL,
  `gun` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `saat` varchar(250) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `ihtiyac_saati`
--

INSERT INTO `ihtiyac_saati` (`ihtiyac_id`, `hasta_id`, `gun`, `saat`) VALUES
(1, 2, 'Pazartesi', '5'),
(2, 3, 'Pazartesi', '5'),
(3, 0, 'Pazartesi', '5'),
(4, 0, 'Pazartesi', '5'),
(8, 2, 'Salı', '18.00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `isler`
--

CREATE TABLE `isler` (
  `is_id` int(11) NOT NULL,
  `personel_id` int(11) NOT NULL,
  `hasta_id` int(11) NOT NULL,
  `is_yapilan` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `ucret` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `tarih` varchar(250) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `isler`
--

INSERT INTO `isler` (`is_id`, `personel_id`, `hasta_id`, `is_yapilan`, `ucret`, `tarih`) VALUES
(3, 3, 2, 'asasasa', '222', 'das'),
(5, 1, 2, 'Şaplak', '222', 'das'),
(6, 0, 1, 'asdsa', 'sadsa', 'sadsa'),
(8, 1, 3, 'sadasdas', 'sadas', 'sadsa'),
(11, 0, 3, 'asdsa', 'sadsa', 'sadsa'),
(12, 0, 3, 'asdsa', 'sadsa', 'sadsa'),
(13, 0, 3, 'Yapılan Deneme', 'sadsa', '11231'),
(14, 58, 3, 'Yapılan Deneme', 'sadsa', '11231'),
(15, 58, 2, 'Deneme 798', 'sadsa', 'sadsa'),
(16, 0, 2, 'Deneme 799', 'sadsadsa', 'sadsadsa'),
(17, 58, 2, 'Deneme 799', 'sadsadsa', 'sadsa'),
(18, 0, 3, 'Deneme 800', 'sadsa', 'sadsa'),
(19, 59, 2, 'Deneme801', 'sadsa', 'sadsa'),
(20, 59, 3, 'Deneme 802', '11231', 'sadsa');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personeller`
--

CREATE TABLE `personeller` (
  `personel_id` int(11) NOT NULL,
  `personel_adsoyad` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `personel_telefon` varchar(15) COLLATE utf8_turkish_ci NOT NULL,
  `personel_cinsiyet` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `personel_brans` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `personeller`
--

INSERT INTO `personeller` (`personel_id`, `personel_adsoyad`, `personel_telefon`, `personel_cinsiyet`, `personel_brans`) VALUES
(77, 'Mehmet Yılmaz', '0555-555-5555', 'Erkek', 1),
(78, 'Ahmet Demir', '0555-555-5555', 'Erkek', 3),
(79, 'Ayşe Bulut', '0555-555-5555', 'Kadın', 2),
(80, 'asdsadas', 'sdasda', 'sadsadsa', 1),
(81, 'asdsadsadsa', 'sdasda', 'asdasdsa', 1),
(82, 'asdsadas', 'sdasda', 'sadsadsa', 1),
(83, 'asdsadas', 'sdasda', 'sadsadsa', 1),
(84, 'asdsadas', 'sdasda', 'sadsadsa', 1),
(85, 'asdsadsadsa', 'sdasda', 'sadsadsa', 1),
(86, 'asdsadas', 'sdasda', 'sadsadsa', 1),
(87, 'asdsadsadsa', 'sdasda', 'sadsadsa', 1),
(88, 'asdsadsadsa', 'sdasda', 'asdasdsa', 3),
(89, 'Emir Said', '5555555', 'Erkek', 1),
(90, 'Emir Said', '5555555', 'Erkek', 1),
(91, 'Emir Said', '5555555', 'Erkek', 1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `adres`
--
ALTER TABLE `adres`
  ADD PRIMARY KEY (`adres_id`);

--
-- Tablo için indeksler `bossaatler`
--
ALTER TABLE `bossaatler`
  ADD PRIMARY KEY (`bossaatler_id`);

--
-- Tablo için indeksler `brans`
--
ALTER TABLE `brans`
  ADD PRIMARY KEY (`brans_id`);

--
-- Tablo için indeksler `file`
--
ALTER TABLE `file`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `hasta_kayit`
--
ALTER TABLE `hasta_kayit`
  ADD PRIMARY KEY (`hasta_id`);

--
-- Tablo için indeksler `ihtiyac_saati`
--
ALTER TABLE `ihtiyac_saati`
  ADD PRIMARY KEY (`ihtiyac_id`);

--
-- Tablo için indeksler `isler`
--
ALTER TABLE `isler`
  ADD PRIMARY KEY (`is_id`);

--
-- Tablo için indeksler `personeller`
--
ALTER TABLE `personeller`
  ADD PRIMARY KEY (`personel_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `adres`
--
ALTER TABLE `adres`
  MODIFY `adres_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Tablo için AUTO_INCREMENT değeri `bossaatler`
--
ALTER TABLE `bossaatler`
  MODIFY `bossaatler_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- Tablo için AUTO_INCREMENT değeri `brans`
--
ALTER TABLE `brans`
  MODIFY `brans_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Tablo için AUTO_INCREMENT değeri `file`
--
ALTER TABLE `file`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Tablo için AUTO_INCREMENT değeri `hasta_kayit`
--
ALTER TABLE `hasta_kayit`
  MODIFY `hasta_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Tablo için AUTO_INCREMENT değeri `ihtiyac_saati`
--
ALTER TABLE `ihtiyac_saati`
  MODIFY `ihtiyac_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Tablo için AUTO_INCREMENT değeri `isler`
--
ALTER TABLE `isler`
  MODIFY `is_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- Tablo için AUTO_INCREMENT değeri `personeller`
--
ALTER TABLE `personeller`
  MODIFY `personel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
