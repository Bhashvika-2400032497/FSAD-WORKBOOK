# Skill 10 - React State Management (useState Object)

This project implements a `StudentManager` React component that:

- Stores students as an object array using `useState`
- Adds students dynamically from input fields (`id`, `name`, `course`)
- Deletes students instantly without page refresh
- Shows an empty state message when no students exist

## Project Structure

- `src/StudentManager.jsx`: core component logic for add/delete/display
- `src/App.jsx`: renders `StudentManager`
- `src/App.css` and `src/index.css`: UI styling

## Run Locally

```bash
npm install
npm run dev
```

## Build

```bash
npm run build
```

## GitHub Push Steps

```bash
git init
git add .
git commit -m "Add StudentManager useState object array implementation"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```

Replace `<your-username>` and `<your-repo>` with your GitHub details.
