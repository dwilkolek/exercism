use std::fmt;

// #[derive(Debug)]
pub struct Clock {
    state: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        Clock {
            state: reduce_state(hours * 60 + minutes),
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Clock {
            state: reduce_state(self.state + minutes),
        }
    }
}

impl fmt::Debug for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.debug_tuple("").field(&self.state).finish()
    }
}

impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{:02}:{:02}", self.state / 60, self.state % 60)
    }
}

impl PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        self.state == other.state
    }
}

fn reduce_state(state: i32) -> i32 {
    let hours = state / 60 % 24;
    let minutes = state % 60;
    let reduced = hours * 60 + minutes;
    if reduced < 0 {
        return reduce_state(reduced + 1440);
    }
    reduced
}
