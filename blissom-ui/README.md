# Blissom UI

Blissom UI is a frontend application built using Vue.js and Vite. It provides a modern and responsive user interface for the Blissom platform, utilizing Vue Router for navigation and Vuex for state management.

## Features
- **Vue 3** for building reactive user interfaces.
- **Vite** as the build tool for fast development.
- **Vue Router** for client-side routing.
- **Vuex** for state management.
- **Axios** for API calls.
- **Bootstrap** for styling and responsive design.
- **Chart.js** for data visualization.
- **SCSS** support for enhanced styling.

## Tech Stack
- **Framework:** Vue 3
- **Build Tool:** Vite
- **Routing:** Vue Router
- **State Management:** Vuex
- **Styling:** Bootstrap, SCSS
- **Data Fetching:** Axios

## Installation

### Prerequisites
Ensure you have the following installed on your system:
- **Node.js** (Download from [Node.js](https://nodejs.org/))
- **NPM** (Comes bundled with Node.js)

### Steps to Set Up Locally
1. Clone the repository:
   ```sh
   git clone https://github.com/RishikeshPathak/Blissom-ui.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Blissom-ui
   ```
3. Install dependencies:
   ```sh
   npm install
   ```
4. Run the development server:
   ```sh
   npm run dev
   ```
   The application will be available at `http://localhost:5173/`.

## Build and Deployment
To build the project for production:
```sh
npm run build
```
To preview the built project:
```sh
npm run preview
```

## Project Structure
```
Blissom-ui/
│── src/
│   ├── components/     # Reusable Vue components
│   ├── views/          # Page views
│   ├── router/         # Vue Router configuration
│   ├── store/          # Vuex store
│   ├── assets/         # Static assets (images, styles)
│── public/             # Static public files
│── vite.config.js      # Vite configuration
│── package.json        # Project dependencies and scripts
│── package-lock.json   # Dependency lock file
```

## Contributing
Feel free to fork the repository and submit pull requests. Open an issue if you find any bugs or have feature requests.

## License
This project is licensed under the MIT License.

