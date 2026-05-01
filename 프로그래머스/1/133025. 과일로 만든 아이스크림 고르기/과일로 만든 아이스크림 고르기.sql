-- 코드를 입력하세요
SELECT a.flavor from first_half a join icecream_info b on a.flavor = b.flavor where a.total_order > 3000 and b.ingredient_type = 'fruit_based' order by total_order desc; 