/// "Encipher" with the Atbash cipher.
pub fn encode(plain: &str) -> String {
    let mut encoded = String::new();
    let mut chars_added = 0;
    for c in plain.to_lowercase().chars() {
        let transcoded = transcode(c);
        if let Some(t) = transcoded {
            if chars_added != 0 && chars_added % 5 == 0 {
                encoded.push(' ');
            }
            encoded.push(t);
            chars_added += 1;
        };
    }
    encoded
}

/// "Decipher" with the Atbash cipher.
pub fn decode(cipher: &str) -> String {
    let mut encoded = String::new();
    for c in cipher.to_lowercase().chars() {
        let transcoded = transcode(c);
        if let Some(t) = transcoded {
            encoded.push(t);
        };
    }
    encoded
}

fn transcode(c: char) -> Option<char> {
    if c.is_alphanumeric() {
        if c.is_alphabetic() {
            let c_as_num = c as u8;
            let trans_c: u8 = 122 - (c_as_num - 97);
            return Some(trans_c as char);
        } else {
            return Some(c);
        }
    }
    None
}
