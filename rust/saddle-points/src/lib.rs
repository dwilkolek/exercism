pub fn find_saddle_points(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    let mut result = Vec::new();
    input.iter().enumerate().for_each(|(row_index, row)| {
        row.iter().enumerate().for_each(|(col_index, &value)| {
            if row.iter().all(|&x| value >= x) /*value in this cell is greater or equal every other value in row */
                && input.iter().all(|x| value <= x[col_index]) /* value in this cell is less or equal than any value on row n-th position (column) */ {
                result.push((row_index, col_index))
            }
        })
    });
    result
}
