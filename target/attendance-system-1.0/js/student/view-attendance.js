const elements = document.querySelectorAll('.element-semester');
showOn(elements);
const elementCourse = document.querySelectorAll('.element-course');
showOn(elementCourse);
const elementGroup = document.querySelectorAll('.element-group');
showOn(elementGroup);



function showOn(elements) {
    elements.forEach(element => {
        element.addEventListener('click', () => {
            elements.forEach(e => e.classList.remove('selected'));
            element.classList.add('selected');
        });
    });
}

