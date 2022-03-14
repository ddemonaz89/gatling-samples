package ru.tinkoff.load.myhttpservice.feeders

import io.gatling.core.feeder._
import ru.tinkoff.gatling.feeders._

object Feeders {

  // Для имени компьютера будем использовать рандомную строку с нужным алфавитом.
  val randomComputerName: Feeder[String] =
    RandomRangeStringFeeder("randomComputerName", alphabet = ('A' to 'Z').mkString)

  // Используем фидер для создания рандомной даты
  val introducedDate: Feeder[String] = RandomDateFeeder("introduced")

  // Создаем случайную дату со сдвигом относительно 'introduced' даты
  val discontinuedDate: Feeder[String] = RandomDateRangeFeeder("introduced", "discontinued", 3)

  // Объединяем фидеры в одну переменную для удобств
  val feeders: Feeder[Any] = randomComputerName ** introducedDate ** discontinuedDate

}
