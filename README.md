## JsonSpringMvc
Create a new controller with a different mapping that will only accept Get requests and return randomly generated information in JSON format.
## 8. Spring 3. Spring MVC
## Завдання 4

Створити новий контролер з різним мапінгом, який буде приймати тільки Get-запити та віддавати випадково згенеровану інформацію в JSON-форматі. 

Наприклад, для мапінгу «/uuid» виводити випадково згенерований uuid, для мапінгу «/exchange» виводити випадкове значення курсу валют або для «/exchange/{currency}» виводити значення курсу валюти, переданої в змінному шляху «currency». Для реалізації завдання потрібно буде скористатися анотацією @ResponseBody.

## Заметки

**@ResponseBody** - це анотація в Spring Framework, яка вказує, що повернене значення з методу контролера повинно бути включене в тіло відповіді HTTP-запиту. В іншій перспективі, @ResponseBody можна розглядати як сигнал для Spring Framework, що потрібно сконвертувати повернене значення в певний формат, щоб відправити його як тіло відповіді.

Якщо метод контролера має анотацію @ResponseBody, Spring Framework використовує внутрішній компонент HttpMessageConverter, щоб сконвертувати повернене значення в формат відповіді, який може бути переданий в тілі відповіді. Наприклад, якщо метод повертає Java-об'єкт, то Spring Framework може сконвертувати його в JSON-формат, який потім можна включити в тіло HTTP-відповіді. Якщо метод повертає рядок або масив байтів, то ці значення просто будуть включені в тіло HTTP-відповіді.

@ResponseBody є корисною анотацією, коли ви хочете повернути дані з методу контролера в форматі, відмінному від HTML-сторінки. Наприклад, якщо ви хочете повернути дані у форматі JSON або XML, @ResponseBody дозволить сконвертувати дані в ці формати та передати їх як тіло відповіді.
