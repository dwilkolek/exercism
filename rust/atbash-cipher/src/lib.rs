/// "Encipher" with the Atbash cipher.
pub fn encode(plain: &str) -> String {
    plain
        .to_lowercase()
        .chars()
        .filter(|c| c.is_alphanumeric())
        .map(transcode_character)
        .collect::<Vec<_>>()
        .chunks(5)
        .map(|c| c.iter().collect::<String>())
        .collect::<Vec<String>>()
        .join(" ")
}

/// "Decipher" with the Atbash cipher.
pub fn decode(cipher: &str) -> String {
    cipher
        .to_lowercase()
        .chars()
        .filter(|c| c.is_alphanumeric())
        .map(transcode_character)
        .collect()
}

fn transcode_character(c: char) -> char {
    if c.is_alphabetic() {
        let c_as_num = c as u8;
        let trans_c: u8 = 122 - (c_as_num - 97);
        trans_c as char
    } else {
        c
    }
}
