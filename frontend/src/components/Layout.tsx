import Header from "./Header";

export default function Layout({ children } : { children: React.ReactNode }) {
  return (
    <div className="flex flex-col w-full min-h-screen">
      <div className="w-full h-20">
        <Header />
      </div>
      <main className="w-full grow">
        {children}
      </main>
    </div>
  )
}
