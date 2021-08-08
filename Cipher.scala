object Cipher extends App{
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  val encrypt = (character: Char, key: Int, alphabet: String) => alphabet((alphabet.indexOf(character.toUpper) + key) % alphabet.size)
  val decrypt = (character: Char, key: Int, alphabet: String) => alphabet((alphabet.indexOf(character.toUpper) - key + alphabet.size) % alphabet.size)

  val cipher = (algo: (Char, Int, String) => Char, s: String, key: Int, alphabet: String) => s.map(algo(_,key,alphabet))

  val shift = scala.io.StdIn.readLine("Shify by: ").toInt
  val message = scala.io.StdIn.readLine("Message to encrypt: ")

  val encryptText = cipher( encrypt, message, shift, alphabet)
  val decryptText = cipher(decrypt, encryptText, shift, alphabet)

  print("Encrypted message: ")
  println(encryptText)
  print("Decrypted message: ")
  println(decryptText)

}
