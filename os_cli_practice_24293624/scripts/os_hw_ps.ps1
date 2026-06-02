Get-Process | Sort-Object WorkingSet -Descending | Select -First 5 processname, id, workingset

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP' -ItemType Directory

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file1.txt' -ItemType File

Add-Content -PATH "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file1.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file2.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file2.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file3.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file3.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file4.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file4.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file5.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file5.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file6.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file6.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file7.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file7.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file8.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file8.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file9.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file9.txt" 'This is the OS.'

New-Item -Path 'C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file10.txt' -ItemType File

Add-Content -Path "C:\Users\louis\OneDrive\Desktop\homework 1\os_cli_practice_24293624\scripts\OS_HW_TEMP\file10.txt" 'This is the OS.'


$a = 0

$z = 0

for ($b = 1; $b -lt 51; $b++) {
	if($b % 3 -eq 0) {
		$z += 1
		$a += $b
	}
	if($b % 5 -eq 0) {
		$z += 1
		$a += $b
	}
}

Write-Host "=== DIVISIBLE SUMMARY ==="
Write-Host "Count: $z"
Write-Host "Sum: $a" 