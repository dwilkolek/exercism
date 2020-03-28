use std::collections::HashSet;

pub fn find_saddle_points(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    // let input = vec![vec![9, 8, 7], vec![5, 3, 2], vec![6, 6, 7]];
    // assert_eq!(vec![(1, 0)], find_saddle_points(&input));

    let mut result: Vec<(usize, usize)> = Vec::new();
    let mut possible_saddle_point = HashSet::new();

    for (index_row, row) in input.iter().enumerate() {
        let max = match row.iter().max() {
            Some(x) => x,
            None => &0,
        };

        for (index_col, value) in row.iter().enumerate() {
            if value == max {
                possible_saddle_point.insert((index_row, index_col));
            }
        }
    }
    for saddle_point in possible_saddle_point.iter() {
        let column = input
            .iter()
            .map(|row| row[saddle_point.1])
            .collect::<Vec<u64>>();
        let min = match column.iter().min() {
            Some(x) => x,
            None => &(u64::max_value()),
        };
        for (index, value) in column.iter().enumerate() {
            if value == min && index == saddle_point.0 {
                result.push(*saddle_point);
            }
        }
    }

    result
}
